package co.uk.directlinegroup.tt;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

public class RerunReportMerger {
    static Logger log;
    private static String reportFileName = "Rerun.txt";
    private BufferedWriter bw;

    static {
        log = Logger.getLogger(RerunReportMerger.class);
    }

    public static void main(String[] args) throws Throwable {
        File reportDirectory = new File(args[0]);
        if (reportDirectory.exists()) {
            RerunReportMerger munger = new RerunReportMerger();
            munger.mergeReports(reportDirectory);
        }
    }

    public void mergeReports(File reportDirectory) throws Throwable {

        Path targetReportPath = Paths.get(reportDirectory.toString() + File.separator + reportFileName);
        if (Files.exists(targetReportPath, LinkOption.NOFOLLOW_LINKS)) {
            FileUtils.forceDelete(targetReportPath.toFile());
        }

        File mergedReport = null;
        Collection<File> existingReports = FileUtils.listFiles(reportDirectory, new String[]{"txt"}, true);

        for (File report : existingReports) {
            if (!report.getName().equals(reportFileName)) {
                if (mergedReport == null) {
                    mergedReport = new File(reportDirectory, reportFileName);
                    mergedReport.createNewFile();
                }
                mergeFiles(mergedReport, report);
            }
        }

        splitBasedOnLine(reportDirectory, mergedReport);
    }

    public void mergeFiles(File target, File source) throws Throwable {
        String targetReport = FileUtils.readFileToString(target);
        String sourceReport = FileUtils.readFileToString(source).replace("/data/workspace/OPR Regression/", "");
        try {
            targetReport = targetReport.concat(sourceReport);
            FileWriter fw = new FileWriter(target.getAbsolutePath());
            bw = new BufferedWriter(fw);
            bw.write(targetReport);
            bw.flush();
            System.out.println("written file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getTotalLines(File mergedReport) {
        StringBuffer strBuff = new StringBuffer();
        int linenumber = 0;
        try {
            FileReader fr = new FileReader(mergedReport);
            LineNumberReader lnr = new LineNumberReader(fr);
            while (lnr.readLine() != null) {
                linenumber++;
            }
            System.out.println("Total number of lines : " + linenumber);
            lnr.close();
            return linenumber;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void splitBasedOnLine(File reportDirectory, File mergedReport) {
        try {
            int count = 0;
            BufferedReader br = null;
            FileWriter fileWriter1 = new FileWriter(Paths.get(reportDirectory.toString() + File.separator + "Rerun1.txt").toFile());
            FileWriter fileWriter2 = new FileWriter(Paths.get(reportDirectory.toString() + File.separator + "Rerun2.txt").toFile());
            FileWriter fileWriter3 = new FileWriter(Paths.get(reportDirectory.toString() + File.separator + "Rerun3.txt").toFile());
            FileWriter fileWriter4 = new FileWriter(Paths.get(reportDirectory.toString() + File.separator + "Rerun4.txt").toFile());
            String currentLine;
            br = new BufferedReader(new FileReader(mergedReport));
            while ((currentLine = br.readLine()) != null) {
                count++;
                if ((count % 4 == 0)) {
                    fileWriter1.write(currentLine + "\n");
                } else if ((count % 4 == 1)) {
                    fileWriter2.write(currentLine + "\n");
                } else if ((count % 4 == 2)) {
                    fileWriter3.write(currentLine + "\n");
                } else {
                    fileWriter4.write(currentLine + "\n");
                }
            }
            if (br != null) {
                br.close();
            }
            fileWriter1.close();
            fileWriter2.close();
            fileWriter3.close();
            fileWriter4.close();
        } catch (Exception e) {
        }
    }
}