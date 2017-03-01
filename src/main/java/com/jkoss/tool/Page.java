package com.jkoss.tool;
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
   
/** 
 * 锟皆凤拷页锟侥伙拷锟斤拷锟斤拷锟捷斤拷锟斤拷一锟斤拷锟津单的凤拷装 
 */  
public class Page<T> {  
   
    private int pageNo = 1;//页锟诫，默锟斤拷锟角碉拷一页  
    private int pageSize = 5;//每页锟斤拷示锟侥硷拷录锟斤拷锟斤拷默锟斤拷锟斤拷15  
    private int totalRecord;//锟杰硷拷录锟斤拷  
    private int totalPage;//锟斤拷页锟斤拷  
    private List<T> results;//锟斤拷应锟侥碉拷前页锟斤拷录  
    private Map<String, Object> params = new HashMap<String, Object>();//锟斤拷锟斤拷锟侥诧拷锟斤拷锟斤拷锟角帮拷锟斤拷锟斤拷装锟斤拷一锟斤拷Map锟斤拷锟斤拷  
   
    public int getPageNo() {  
       return pageNo;  
    }  
   
    public void setPageNo(int pageNo) {  
       this.pageNo = pageNo;  
    }  
   
    public int getPageSize() {  
       return pageSize;  
    }  
   
    public void setPageSize(int pageSize) {  
       this.pageSize = pageSize;  
    }  
   
    public int getTotalRecord() {  
       return totalRecord;  
    }  
   
    public void setTotalRecord(int totalRecord) {  
       this.totalRecord = totalRecord;  
       //锟斤拷锟斤拷锟斤拷锟斤拷页锟斤拷锟斤拷时锟斤拷锟斤拷锟斤拷锟斤拷应锟斤拷锟斤拷页锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟侥匡拷锟斤拷锟斤拷屑臃锟接碉拷懈锟斤拷叩锟斤拷锟斤拷燃锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷圆锟斤拷锟斤拷锟斤拷拧锟�  
       int totalPage = totalRecord%pageSize==0 ? totalRecord/pageSize : totalRecord/pageSize + 1;  
       this.setTotalPage(totalPage);  
    }  
   
    public int getTotalPage() {  
       return totalPage;  
    }  
   
    public void setTotalPage(int totalPage) {  
       this.totalPage = totalPage;  
    }  
   
    public List<T> getResults() {  
       return results;  
    }  
   
    public void setResults(List<T> results) {  
       this.results = results;  
    }  
     
    public Map<String, Object> getParams() {  
       return params;  
    }  
     
    public void setParams(Map<String, Object> params) {  
       this.params = params;  
    }  
   
    @Override  
    public String toString() {  
       StringBuilder builder = new StringBuilder();  
       builder.append("Page [pageNo=").append(pageNo).append(", pageSize=")  
              .append(pageSize).append(", results=").append(results).append(  
                     ", totalPage=").append(totalPage).append(  
                     ", totalRecord=").append(totalRecord).append("]");  
       return builder.toString();  
    }  
   
}  