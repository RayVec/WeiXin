package Info;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/16.
 */
public class TextFile {
    private String openId;
    private String filename;
    private String localurl;
    private String status;
    private int wordNum;
    private double price=wordNum*0.001;
    private String newurl;
    private Date createtime;
    public TextFile(){

    }
    public TextFile(String a){

    }
    public int getWordNum() {
        return wordNum;
    }
    public String getOpenId(){return openId;}
    public void setOpenId(String openId){this.openId=openId;}
    public String getFilename(){
        return filename;
    }
    public void setFilename(String filename){this.filename=filename;}
    public String getLocalurl(){
        return localurl;
    }
    public void setLocalurl(String localurl){this.localurl=localurl;}
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){this.status=status;}
    public double getPrice(){
        return price;
    }
    public void setWordNum(int wordNum){this.wordNum=wordNum;}
    public void setNewurl(String newurl){this.newurl=newurl;}
    public String getNewurl(){return newurl;}
    public void setCreatetime(Date createtime){this.createtime=createtime;}
    public Date getCreatetime(){return createtime;}

}
