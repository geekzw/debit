package com.gujian.debitapp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gujian
 * Time is 2017/10/17
 * Email is gujian@maihaoche.com
 */

public class HelpEntity implements Serializable {
    /**
     * data : {"list":[{"id":"1","name":"网上申请借款，审核一般需要多久？","answer":["根据申请信息的完整性的不同，审核速度也不同，最快当天就可以通过审核"]},{"id":"2","name":"网上申请借款如何加快审核速度？","answer":["1、保证填写信息的真实性","2、信息的完整性，一般信息填写越完整，审核速度越快"]},{"id":"3","name":"从审核到下款一般需要多久？","answer":["一般来说，市场上完成放款的时间为1-7天。每家机构的放款速度是不一样，只需要申请材料齐全，最快当天就能审核放款。"]},{"id":"4","name":"如何保证个人贷款的审核通过率？\t","answer":["申请个人贷款要重视自身的信用报告、还清未还贷款、如实填写资产证明、工作证明、居住状况等，则可以增加个人贷款通过率"]},{"id":"5","name":"机构/银行审核无抵押信用贷款考虑的因素有哪些？\t","answer":["1、个人信用记录","2、个人负债比率","3、个人就业纪录","4、贷款额上限，一般的标准是，无抵押的个人贷款不应超过申请人每月基本收入的10倍","5、贷款期限，短期贷款期限一般在一年内，最长的贷款期限通"]},{"id":"6","name":"如何顺利通过电话审核？","answer":["1、保证填写信息的真实性","2、本人或者填写的联系人通讯保持畅通","3、回答内容和申请表填写的内容一致"]},{"id":"7","name":"电话审核一般核实哪些问题？","answer":["1、核对姓名","2、核对身份证号码","3、借款用途","4、提交申请填写过的信息","5、资产信息","6、工作信息","7、个人征信情况等"]},{"id":"8","name":"申请贷款的基本要求是什么？","answer":["1、年龄20-60周岁的具有合法收入和还款能力的中国公民","2、具有稳定的工资收入，具有如期偿还贷款的能力","3、没有不良信用记录"]},{"id":"10","name":"信用白户可以申请贷款吗？","answer":["虽然大部分银行和小贷公司都要求借款人必须有信用记录，但是也会有一些小额信贷公司允许信用白户个人申请，但在利率方面会比银行高。"]},{"id":"11","name":"信用白户如何申请贷款？","answer":["1、尝试多个匹配机构，不是所有机构都提供白户贷款，寻找合适的机构才更重要，您可以通过掌上金融匹配合适的机构。","2、信用卡开道，在贷款之前申请使用信用卡，保持良好的信用记录也是一种有效的解决办法。"]},{"id":"12","name":"无抵押贷款与抵押贷款的区别？","answer":["1、申请门槛不同，申请无抵押贷款需要考虑个人资质，而申请抵押贷款，需要考虑抵押物。","2、额度不同，无抵押贷款额度以借款人月入10倍左右为主打，而抵押贷款额度通常为抵押物评估值的70%。"]},{"id":"13","name":"影响贷款利息的因数有哪些？","answer":["1、贷款机构，银行对申请人的要求高，贷款公司要求稍低。正因为此，贷款公司的贷款利息通常稍高于银行。","2、申请人职业性质，很多贷款机构针对公务员、事业单位员工等职业推出的无抵押贷款产品，利息要低于普通。"]},{"id":"14","name":"什么是一次性还本付息还款？","answer":["一次还本付息又称到期一次还本付息法，是指借款人在贷款到期后一次性归还本金和利息。一般对这种还款方式的规定是，贷款期限在一年（含一年）以下的，实行到期一次还本付息，利随本清。"]},{"id":"15","name":"分期还款和到期还款有什么区别？","answer":["1、\u201c按月分期还款\u201d是指采用\u201c等额本息还款方式\u201d或\u201c等额本金还款方式\u201c，按月偿还贷款本金和利息。","2、\u201c到期全额还款\u201d是指采用每月付息，到期全额还本的计算方式。"]},{"id":"16","name":"暂时还不上贷款怎么办？","answer":["1、找亲朋好友筹借。","2、贷款到期不能按时归还，需提前跟放款平台协商延期，一般放款平台可以受理这样的请求。"]},{"id":"17","name":"如何给贷款成功率加分？","answer":["1、平时保证良好的信用记录，因为机构或银行是否放贷决定的关键还是看借款人能不能按时还贷。","2、保证稳定的银行流水，机构或银行重视的是申请者稳定且合理的银行流水。","3、有一定资产，大额资产证明是贷款审核。"]},{"id":"18","name":"如何提高网申贷款成功率？","answer":["1、完整填写申请资料，资料完整会加快机构或平台审核的效率。","2、提交准确真实的身份信息，\u201c提供虚假信息\u201d会造成申请人不诚信的印象，直接影响贷款结果。","3、随时保持通讯畅通，一般网申贷款会有电话审核"]},{"id":"19","name":"哪些人贷款成功率高？","answer":["1、银行VIP客户","2、公务员、事业单位、500强、企业职工","3、收入稳定的工薪一族"]},{"id":"20","name":"哪些因素可能会阻碍贷款成功率?","answer":["1、征信记录被频繁查询","2、信用卡、房贷、车贷、助学贷款等逾期或不还","3、有过严重的交通失信记录"]},{"id":"21","name":"哪些情况会导致信用贷款被拒？","answer":["1、信用不良，近期内有连续三次或累计六次的借款/信用卡逾期。","2、工作不稳定。","3、无法提供完整资料。"]}],"total_page":"2"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * list : [{"id":"1","name":"网上申请借款，审核一般需要多久？","answer":["根据申请信息的完整性的不同，审核速度也不同，最快当天就可以通过审核"]},{"id":"2","name":"网上申请借款如何加快审核速度？","answer":["1、保证填写信息的真实性","2、信息的完整性，一般信息填写越完整，审核速度越快"]},{"id":"3","name":"从审核到下款一般需要多久？","answer":["一般来说，市场上完成放款的时间为1-7天。每家机构的放款速度是不一样，只需要申请材料齐全，最快当天就能审核放款。"]},{"id":"4","name":"如何保证个人贷款的审核通过率？\t","answer":["申请个人贷款要重视自身的信用报告、还清未还贷款、如实填写资产证明、工作证明、居住状况等，则可以增加个人贷款通过率"]},{"id":"5","name":"机构/银行审核无抵押信用贷款考虑的因素有哪些？\t","answer":["1、个人信用记录","2、个人负债比率","3、个人就业纪录","4、贷款额上限，一般的标准是，无抵押的个人贷款不应超过申请人每月基本收入的10倍","5、贷款期限，短期贷款期限一般在一年内，最长的贷款期限通"]},{"id":"6","name":"如何顺利通过电话审核？","answer":["1、保证填写信息的真实性","2、本人或者填写的联系人通讯保持畅通","3、回答内容和申请表填写的内容一致"]},{"id":"7","name":"电话审核一般核实哪些问题？","answer":["1、核对姓名","2、核对身份证号码","3、借款用途","4、提交申请填写过的信息","5、资产信息","6、工作信息","7、个人征信情况等"]},{"id":"8","name":"申请贷款的基本要求是什么？","answer":["1、年龄20-60周岁的具有合法收入和还款能力的中国公民","2、具有稳定的工资收入，具有如期偿还贷款的能力","3、没有不良信用记录"]},{"id":"10","name":"信用白户可以申请贷款吗？","answer":["虽然大部分银行和小贷公司都要求借款人必须有信用记录，但是也会有一些小额信贷公司允许信用白户个人申请，但在利率方面会比银行高。"]},{"id":"11","name":"信用白户如何申请贷款？","answer":["1、尝试多个匹配机构，不是所有机构都提供白户贷款，寻找合适的机构才更重要，您可以通过掌上金融匹配合适的机构。","2、信用卡开道，在贷款之前申请使用信用卡，保持良好的信用记录也是一种有效的解决办法。"]},{"id":"12","name":"无抵押贷款与抵押贷款的区别？","answer":["1、申请门槛不同，申请无抵押贷款需要考虑个人资质，而申请抵押贷款，需要考虑抵押物。","2、额度不同，无抵押贷款额度以借款人月入10倍左右为主打，而抵押贷款额度通常为抵押物评估值的70%。"]},{"id":"13","name":"影响贷款利息的因数有哪些？","answer":["1、贷款机构，银行对申请人的要求高，贷款公司要求稍低。正因为此，贷款公司的贷款利息通常稍高于银行。","2、申请人职业性质，很多贷款机构针对公务员、事业单位员工等职业推出的无抵押贷款产品，利息要低于普通。"]},{"id":"14","name":"什么是一次性还本付息还款？","answer":["一次还本付息又称到期一次还本付息法，是指借款人在贷款到期后一次性归还本金和利息。一般对这种还款方式的规定是，贷款期限在一年（含一年）以下的，实行到期一次还本付息，利随本清。"]},{"id":"15","name":"分期还款和到期还款有什么区别？","answer":["1、\u201c按月分期还款\u201d是指采用\u201c等额本息还款方式\u201d或\u201c等额本金还款方式\u201c，按月偿还贷款本金和利息。","2、\u201c到期全额还款\u201d是指采用每月付息，到期全额还本的计算方式。"]},{"id":"16","name":"暂时还不上贷款怎么办？","answer":["1、找亲朋好友筹借。","2、贷款到期不能按时归还，需提前跟放款平台协商延期，一般放款平台可以受理这样的请求。"]},{"id":"17","name":"如何给贷款成功率加分？","answer":["1、平时保证良好的信用记录，因为机构或银行是否放贷决定的关键还是看借款人能不能按时还贷。","2、保证稳定的银行流水，机构或银行重视的是申请者稳定且合理的银行流水。","3、有一定资产，大额资产证明是贷款审核。"]},{"id":"18","name":"如何提高网申贷款成功率？","answer":["1、完整填写申请资料，资料完整会加快机构或平台审核的效率。","2、提交准确真实的身份信息，\u201c提供虚假信息\u201d会造成申请人不诚信的印象，直接影响贷款结果。","3、随时保持通讯畅通，一般网申贷款会有电话审核"]},{"id":"19","name":"哪些人贷款成功率高？","answer":["1、银行VIP客户","2、公务员、事业单位、500强、企业职工","3、收入稳定的工薪一族"]},{"id":"20","name":"哪些因素可能会阻碍贷款成功率?","answer":["1、征信记录被频繁查询","2、信用卡、房贷、车贷、助学贷款等逾期或不还","3、有过严重的交通失信记录"]},{"id":"21","name":"哪些情况会导致信用贷款被拒？","answer":["1、信用不良，近期内有连续三次或累计六次的借款/信用卡逾期。","2、工作不稳定。","3、无法提供完整资料。"]}]
         * total_page : 2
         */

        private String total_page;
        private List<ListBean> list;

        public String getTotal_page() {
            return total_page;
        }

        public void setTotal_page(String total_page) {
            this.total_page = total_page;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 1
             * name : 网上申请借款，审核一般需要多久？
             * answer : ["根据申请信息的完整性的不同，审核速度也不同，最快当天就可以通过审核"]
             */

            private String id;
            private String name;
            private List<String> answer;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<String> getAnswer() {
                return answer;
            }

            public void setAnswer(List<String> answer) {
                this.answer = answer;
            }
        }
    }

//    private List<Entity> list;
//
//    public List<Entity> getList() {
//        return list;
//    }
//
//    public void setList(List<Entity> list) {
//        this.list = list;
//    }
//
//    public static class Entity{
//
//        private String id;
//
//        private String name;
//
//        private List<String> answer;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public List<String> getAnswer() {
//            return answer;
//        }
//
//        public void setAnswer(List<String> answer) {
//            this.answer = answer;
//        }
//    }
}