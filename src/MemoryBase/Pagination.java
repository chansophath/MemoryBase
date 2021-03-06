package MemoryBase;
import java.util.ArrayList;


public class Pagination {
	public static int page=1;
	public static int perpage=10;	
	
	public void showPage(ArrayList<Article> arr, int page,int perpage,String act,UI ui){
		int cArr = arr.size();
		
		if(cArr>0){
			int total_page = (int) Math.ceil((cArr/(float)perpage));
			
			switch (act) {
				case "L":
					this.page=total_page;
					page = total_page;
					break;
				case "P":
					if(page!=1){
						this.page--;
						page--;
					}else{
						System.out.println("This is the first page. Can not Previous.");
					}
					break;
				case "F":
					this.page=1;
					page=1;
					break;
				case "N":
					if(page==total_page){
						System.out.println("This is the last page. Can not Next.");
					}else{
						this.page++;
						page++;
					}
					break;
				case "R":
					if(perpage>cArr){
						System.out.println("Show row can be not bigger than record.");
					}else{
						this.perpage=perpage;
					}
					break;
				default:
					break;
			}
			
			int start = (page-1)*perpage;
			int stop = start+perpage;
			
			
			if(page == total_page){
				if(cArr%perpage != 0)
					stop= start+cArr%perpage;
			}
		
			if(page>total_page){ 
				System.out.println("page not found!!!");
				start=0;
				stop=0;
			}	
			ui.table_head();	
			for(int i=start;i<stop;i++){
				String[] str ={""+arr.get(i).getId(),arr.get(i).getTitle(),arr.get(i).getAuthor(),"02/12/2015"};
				ui.tbl_row(str);			
			}
			ui.tbl_footer(page, total_page, cArr,ui.width);
		}else{
			System.out.println("No record!");
		}
	}
}
