package co.uk.directlinegroup.tt.utils.common;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class FileOperations {

    public List<String> getClaimData(String header) {
        Properties prop = new Properties();
        InputStream input = null;
        List<String> lstClaimHeaderDetails = new ArrayList<String>();

        try {
            input = new FileInputStream("src/test/resources/ClaimDetails.properties");
            prop.load(input);
            String claimHeader = prop.getProperty(header);
            String[] arrClaimHeaderDetails = claimHeader.split("#");
            lstClaimHeaderDetails = Arrays.asList(arrClaimHeaderDetails);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lstClaimHeaderDetails;
    }

    public List<String> getPolicyData(String header) {
        Properties prop = new Properties();
        InputStream input = null;
        List<String> lstPolicyHeader = new ArrayList<String>();

        try {
            input = new FileInputStream("src/test/resources/PolicyDetails.properties");
            prop.load(input);
            String claimHeader = prop.getProperty(header);
            String[] arrClaimHeaderDetails = claimHeader.split("#");
            lstPolicyHeader = Arrays.asList(arrClaimHeaderDetails);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lstPolicyHeader;
    }

    public List<String> getDigitalPolicyData(String header) {
        Properties prop = new Properties();
        InputStream input = null;
        List<String> lstPolicyHeader = new ArrayList<String>();

        try {
            input = new FileInputStream("src/test/resources/DigitalCustomerSetup.properties");
            prop.load(input);
            String claimHeader = prop.getProperty(header);
            String[] arrClaimHeaderDetails = claimHeader.split("#");
            lstPolicyHeader = Arrays.asList(arrClaimHeaderDetails);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lstPolicyHeader;
    }

    public List<String> getQuoteData(String header) {
        Properties prop = new Properties();
        InputStream input = null;
        List<String> lstPolicyHeader = new ArrayList<String>();

        try {
            input = new FileInputStream("src/test/resources/QuoteAndBuy.properties");
            prop.load(input);
            String strHeader = prop.getProperty(header);
            String[] arrHeaderDetails = strHeader.split("#");
            lstPolicyHeader = Arrays.asList(arrHeaderDetails);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lstPolicyHeader;
    }
    public List<String> getPerilQuestions(String header) {
        Properties prop = new Properties();
        InputStream input = null;
        List<String> lstPerilQues = new ArrayList<String>();

        try {
            input = new FileInputStream("src/test/resources/PerilQuestions.properties");
            prop.load(input);
            String perilHeader = prop.getProperty(header);
            String[] arrPerilHeader = perilHeader.split("#");
            lstPerilQues = Arrays.asList(arrPerilHeader);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lstPerilQues;
    }

    public String getInboudFilePath(String strIntegrationType) {
        Properties prop = new Properties();
        InputStream input = null;
        String strFilePath = "NOTHING";

        try {
            input = new FileInputStream("src/test/resources/InboudFilePathForIntegration.properties");
            prop.load(input);
            strFilePath = prop.getProperty(strIntegrationType);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return strFilePath;
    }

    public List<String> getQuoteAndBuyData(String pages) {
        Properties prop = new Properties();
        InputStream input = null;
        List<String> listQuoteAndBugQuestionsAndAnswers = new ArrayList<String>();

        try {
            input = new FileInputStream("src/test/resources/QuoteAndBuy.properties");
            prop.load(input);
            String quoteAndBuyQuestionsAndAnswer = prop.getProperty(pages);
            String[] splitedQuestionAndAnswer = quoteAndBuyQuestionsAndAnswer.split("&");
            listQuoteAndBugQuestionsAndAnswers = Arrays.asList(splitedQuestionAndAnswer);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listQuoteAndBugQuestionsAndAnswers;
    }

    public List<String> getHazardousActivitiesData(String header) {
        Properties prop = new Properties();
        InputStream input = null;
        List<String> lstActivities = new ArrayList<String>();

        try {
            input = new FileInputStream("src/test/resources/HazardousCoverActivities.properties");
            prop.load(input);
            String perilHeader = prop.getProperty(header);
            String[] arrPerilHeader = perilHeader.split("#");
            lstActivities = Arrays.asList(arrPerilHeader);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lstActivities;
    }

    public List<String> getListOfAllDigitalFAQ(String header) {
        Properties prop = new Properties();
        InputStream input = null;
        List<String> lstQuestions = new ArrayList<String>();

        try {
            input = new FileInputStream("src/test/resources/DigitalFAQ.properties");
            prop.load(input);
            String perilHeader = prop.getProperty(header);
            String[] arrPerilHeader = perilHeader.split("#");
            lstQuestions = Arrays.asList(arrPerilHeader);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lstQuestions;
    }

    public List<String> getDigitalQuoteData(String header) {
        Properties prop = new Properties();
        InputStream input = null;
        List<String> lstPolicyHeader = new ArrayList<String>();

        try {
            input = new FileInputStream("src/test/resources/DigitalQuote.properties");
            prop.load(input);
            String strHeader = prop.getProperty(header);
            String[] arrHeaderDetails = strHeader.split("#");
            lstPolicyHeader = Arrays.asList(arrHeaderDetails);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lstPolicyHeader;
    }

    public List<String> getContributionClaimData(String header) {
        Properties prop = new Properties();
        InputStream input = null;
        List<String> lstClaimHeaderDetails = new ArrayList<String>();

        try {
            input = new FileInputStream("src/test/resources/ContributionClaimDetails.properties");
            prop.load(input);
            String claimHeader = prop.getProperty(header);
            String[] arrClaimHeaderDetails = claimHeader.split("#");
            lstClaimHeaderDetails = Arrays.asList(arrClaimHeaderDetails);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lstClaimHeaderDetails;
    }

    public List<String> getDigitalClaimData(String header) {
        Properties prop = new Properties();
        InputStream input = null;
        List<String> lstClaimHeaderDetails = new ArrayList<String>();

        try {
            input = new FileInputStream("src/test/resources/DigitalClaimDetails.properties");
            prop.load(input);
            String claimHeader = prop.getProperty(header);
            String[] arrClaimHeaderDetails = claimHeader.split("#");
            lstClaimHeaderDetails = Arrays.asList(arrClaimHeaderDetails);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lstClaimHeaderDetails;
    }


    public String getApplicationURL(String header) {
        Properties prop = new Properties();
        InputStream input = null;
        String applicationURL = null;

        try {
            input = new FileInputStream("src/test/resources/ApplicationURL.properties");
            prop.load(input);
            applicationURL = prop.getProperty(header);
            System.out.println("Application URL "+applicationURL);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return applicationURL;
    }
    //TODO-Sruthi Start
    public List<String> getPropValue(String property, boolean isheader, Properties prop) {

        List<String> returnList = new ArrayList<String>();

        try {
            String values = prop.getProperty(property);
            if (null == values) {
                values = getCommonProperties(property);
                if (null == values) {
                    values = property;
                }
            }
            System.out.println( "Before Split::" + values);

            String[] listOfItems = values.split("#");
            System.out.println( "listOfItems::" + listOfItems);
            if (!isheader) {
                for (String item : listOfItems) {
                    String value = null;
                    if (null != item && !"".equalsIgnoreCase(item)) {
                        value = prop.getProperty(item);
                        if (null == value) {
                            value = getCommonProperties(item);
                            if (null == value) {
                                value = item;
                            }
                        }
                    } else {
                        value = item;
                    }
                    System.out.println("value:: " + value);
                    returnList.add(value);
                }
            } else {

                returnList = Arrays.asList(listOfItems);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return returnList;
    }

    public List<String> getDynamicPerilQuestions(String header) {
        Properties prop = new Properties();
        InputStream input = null;
        List<String> lstPerilQues = new ArrayList<String>();

        try {
            input = new FileInputStream("src/test/resources/DynamicPerilQuestions.properties");
            prop.load(input);
            String perilHeader = prop.getProperty(header);
            String[] arrPerilHeader = perilHeader.split("#");
            lstPerilQues = Arrays.asList(arrPerilHeader);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lstPerilQues;
    }

    public String getCommonProperties(String property) {
        Properties prop = LoadTTPropertiesFiles.TTCOMMONPROPLIST;
        String value = prop.getProperty(property);
        return value;

    }
    //TODO-Sruthi End
    public String getCustomerCreationAPI(String header) {
        Properties prop = new Properties();
        InputStream input = null;
        String lstClaimHeaderDetails = "";

        try {
            input = new FileInputStream("src/test/resources/CustomerCreationAPI.properties");
            prop.load(input);
            lstClaimHeaderDetails = prop.getProperty(header);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lstClaimHeaderDetails;
    }

    //For Template reading
    public String readFile(String filePath){
        StringBuilder stringBuil = new StringBuilder();
        File file = null;
        BufferedReader bfReader = null;
        FileReader fileReader = null;
        try{
            System.out.println("filePath:: "+filePath);
            file = new File(filePath);
            fileReader = new FileReader(file.getAbsolutePath());
            if(file.exists()){
                bfReader = new BufferedReader(fileReader);
                String line = bfReader.readLine();
                while(line!=null){
                    stringBuil.append(line);
                    line=bfReader.readLine();
                    if(line!=null){
                        stringBuil.append("\n");
                    }
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {

            try {

                if (bfReader != null)
                    bfReader.close();

                if (fileReader != null)
                    fileReader.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }

        //System.out.println("Inside String"+stringBuil.toString());
        return stringBuil.toString();
    }


    public  Properties readBasicPropertyFile() {
        // TODO Auto-generated method stub
        Properties prop= new Properties();
        String basicProp="";
        try {
            InputStream fileOut = new FileInputStream("src/test/resources/MappingTemplate.properties");
            prop.load(fileOut);
            //basicProp=prop.getProperty("BasicClaim");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //	return basicProp;
        return prop;

    }
}
