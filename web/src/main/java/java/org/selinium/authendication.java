package org.selinium;
import  org.commonutils.*;//common class munnadi public podanum or default na next class nla inherit pannum 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class authendication  {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
     System.out.println("this is programe for to validdate authendication");
     
     comman.getinstance().launch();
     uploadbytext();
     comman.getinstance().quite();
     
     
     
	}  

	public static   void uploadbytext() {
		Actions obj = new Actions (comman.getdriver());
	    WebElement el=	comman.getdriver().findElement(By.xpath("//input[@id='fileupload1']"));
		obj.moveToElement(el);
		el.sendKeys("C:\\Users\\praka\\OneDrive\\Desktop\\name.txt");
		
		
	}
}
