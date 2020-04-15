package co.uk.directlinegroup.tt.utils.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadTTPropertiesFiles {

    public static final String APPLICATIONURL_PROP = "src/test/resources/ApplicationURL.properties";
    public static final String CLAIMDETAILS_PROP = "src/test/resources/ClaimDetails.properties";
    public static final String CONTRIBUTIONCLAIMD_PROP = "src/test/resources/ContributionClaimDetails.properties";
    public static final String CREDENTIALS_PROP = "src/test/resources/credentials.properties";
    public static final String DIGITALCLAIMDETAIL_PROP = "src/test/resources/DigitalClaimDetails.properties";
    public static final String DIGITALCUSTOMERSETUP_PROP = "src/test/resources/DigitalCustomerSetup.properties";
    public static final String DIGITALFAQ_PROP = "src/test/resources/DigitalFAQ.properties";
    public static final String DIGITALQUOTE_PROP ="src/test/resources/DigitalQuote.properties";
    public static final String DOWNLOADSLINK_PROP = "src/test/resources/DownloadsLink.properties";
    public static final String HAZARDOUSCOVERACTIVITIES_PROP = "src/test/resources/HazardousCoverActivities.properties";
    public static final String INBOUDFILEPATHFORINTEGRATION_PROP = "src/test/resources/InboudFilePathForIntegration.properties";
    public static final String LOGINPROFILES_PROP = "src/test/resources/LoginProfiles.properties";
    public static final String PERILQUESTIONS_PROP = "src/test/resources/PerilQuestions.properties";
    public static final String POLICYDETAILS_PROP = "src/test/resources/PolicyDetails.properties";
    public static final String QUOTEANDBUY_PROP = "src/test/resources/QuoteAndBuy.properties";
    public static final String TTCOMMON_PROP = "src/test/resources/TTCommon.properties";
    public static final String CUSTOEMRCREATIONAPI = "src/test/resources/CustomerCreationAPI.properties";
    public static final String FINANCIALTABLEVALUES = "src/test/resources/FinancialTableValues.properties";

    public static  Properties APPLICATIONURLPROPLIST = null;
    public static  Properties CLAIMDETAILSPROPLIST = null;
    public static  Properties CONTRIBUTIONCLAIMPROPLIST = null;
    public static Properties CREDENTIALSPROPLIST = null;
    public static Properties DIGITALCLAIMDETAILPROPLIST = null;
    public static Properties DIGITALCUSTOMERSETUPPROPLIST = null;
    public static Properties DIGITALFAQPROPLIST = null;
    public static Properties DIGITALQUOTEPROPLIST = null;
    public static Properties DOWNLOADSLINKPROPLIST = null;
    public static Properties HAZARDOUSCOVERACTIVITIESPROPLIST = null;
    public static Properties INBOUDFILEPATHFORINTEGRATIONPROPLIST = null;
    public static Properties LOGINPROFILESPROPLIST = null;
    public static Properties PERILQUESTIONSPROPLIST = null;
    public static Properties POLICYDETAILSPROPLIST = null;
    public static Properties QUOTEANDBUYPROPLIST = null;
    public static Properties TTCOMMONPROPLIST = null;
    public static Properties CUSTOMERCREATIONAPIPROPLIST = null;

    static{

        APPLICATIONURLPROPLIST = getApplnUrlProp();
        CLAIMDETAILSPROPLIST = getClaimDetailsProp();
        CONTRIBUTIONCLAIMPROPLIST = getContribClaimProp();
        CREDENTIALSPROPLIST = getCredentialsProp();
        DIGITALCUSTOMERSETUPPROPLIST = getDigitalCustSetupProp();
        DIGITALFAQPROPLIST = getDigitalFAQProp();
        DIGITALQUOTEPROPLIST = getDigitalQuoteProp();
        DOWNLOADSLINKPROPLIST = getDownloadsLinkProp();
        HAZARDOUSCOVERACTIVITIESPROPLIST = getHazardousCoverActivitiesProp();
        INBOUDFILEPATHFORINTEGRATIONPROPLIST = getInboudFilePathForIntegrationProp();
        LOGINPROFILESPROPLIST = getLoginProfilesProp();
        PERILQUESTIONSPROPLIST = getPerilQuestionsProp();
        POLICYDETAILSPROPLIST = getPolicyDetailsProp();
        QUOTEANDBUYPROPLIST = getQuoteAndBuyProp();
        TTCOMMONPROPLIST = getTTCommonProp();
        DIGITALCLAIMDETAILPROPLIST = getDigitalClaimDetailProp();
        CUSTOMERCREATIONAPIPROPLIST = getCustomerCreationAPI();
    }

    //Read ClaimDetails.properties
    public static Properties getClaimDetailsProp(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(CLAIMDETAILS_PROP);
            prop.load(input);
        }catch (IOException ex) {
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

        return prop;
    }

    //Read credentials.properties
    public static Properties getCredentialsProp(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(CREDENTIALS_PROP);
            prop.load(input);
        }catch (IOException ex) {
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

        return prop;
    }

    //Read DigitalCustomerSetup.properties
    public static Properties getDigitalCustSetupProp(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(DIGITALCUSTOMERSETUP_PROP);
            prop.load(input);
        }catch (IOException ex) {
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

        return prop;
    }

    //Read DigitalFAQ.properties
    public static Properties getDigitalFAQProp(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(DIGITALFAQ_PROP);
            prop.load(input);
        }catch (IOException ex) {
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

        return prop;
    }

    //Read DigitalQuote.properties
    public static Properties getDigitalQuoteProp(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(DIGITALQUOTE_PROP);
            prop.load(input);
        }catch (IOException ex) {
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

        return prop;
    }

    //Read DownloadsLink.properties
    public static Properties getDownloadsLinkProp(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(DOWNLOADSLINK_PROP);
            prop.load(input);
        }catch (IOException ex) {
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

        return prop;
    }

    //Read HazardousCoverActivities.properties
    public static Properties getHazardousCoverActivitiesProp(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(HAZARDOUSCOVERACTIVITIES_PROP);
            prop.load(input);
        }catch (IOException ex) {
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

        return prop;
    }

    //Read InboudFilePathForIntegration.properties
    public static Properties getInboudFilePathForIntegrationProp(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(INBOUDFILEPATHFORINTEGRATION_PROP);
            prop.load(input);
        }catch (IOException ex) {
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

        return prop;
    }

    //Read LoginProfiles.properties
    public static Properties getLoginProfilesProp(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(LOGINPROFILES_PROP);
            prop.load(input);
        }catch (IOException ex) {
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

        return prop;
    }

    //Read PerilQuestions.properties
    public static Properties getPerilQuestionsProp(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(PERILQUESTIONS_PROP);
            prop.load(input);
        }catch (IOException ex) {
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

        return prop;
    }

    //Read PolicyDetails.properties
    public static Properties getPolicyDetailsProp(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(POLICYDETAILS_PROP);
            prop.load(input);
        }catch (IOException ex) {
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

        return prop;
    }

    //Read QuoteAndBuy.properties
    public static Properties getQuoteAndBuyProp(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(QUOTEANDBUY_PROP);
            prop.load(input);
        }catch (IOException ex) {
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

        return prop;
    }

    //Read TTCommon.properties
    public static Properties getTTCommonProp(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(TTCOMMON_PROP);
            prop.load(input);
        }catch (IOException ex) {
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

        return prop;
    }

    //Read TTCommon.properties
    public static Properties getApplnUrlProp(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(APPLICATIONURL_PROP);
            prop.load(input);
        }catch (IOException ex) {
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

        return prop;
    }

    //Read TTCommon.properties
    public static Properties getContribClaimProp(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(CONTRIBUTIONCLAIMD_PROP);
            prop.load(input);
        }catch (IOException ex) {
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

        return prop;
    }

    //Read TTCommon.properties
    public static Properties getDigitalClaimDetailProp(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(DIGITALCLAIMDETAIL_PROP);
            prop.load(input);
        }catch (IOException ex) {
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

        return prop;
    }
    //Read customercreationAPI.properties
    public static Properties getCustomerCreationAPI(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(CUSTOEMRCREATIONAPI);
            prop.load(input);
        }catch (IOException ex) {
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

        return prop;
    }

   }
