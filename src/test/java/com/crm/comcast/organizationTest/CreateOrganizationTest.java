package com.crm.comcast.organizationTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.generic.BaseClass;
import com.vtiger.comcast.pomrepository.CreateNeworganization;
import com.vtiger.comcast.pomrepository.Home;
import com.vtiger.comcast.pomrepository.Organizationinfo;
import com.vtiger.comcast.pomrepository.organization;

@Listeners(com.crm.comcast.generic.ListnerImplementation.class)
public class CreateOrganizationTest extends BaseClass 
{
	@Test(groups="smokeTest")
	public void createorg() throws EncryptedDocumentException, IOException
	{
	
		
		String orgName =eu.getExcelData("Sheet1", 1, 2)+ "_" +ju.randomWeb(1000);
		Home h=new Home(driver);
		h.getOrganizationLnk().click();
		organization o =new organization(driver);
		o.getCreateOrgImg().click();
		CreateNeworganization cz= new CreateNeworganization(driver);
		cz.createOrg(orgName);
		Organizationinfo oi=new Organizationinfo(driver);
		System.out.println(oi.getSuccessfulMsg().getText());
		if (oi.getSuccessfulMsg().getText().contains(orgName))
		{
			System.out.println("organization is created = Pass");
		}
		else
		{
			System.out.println("Organization is not created = Fail");
		}
		
		
		
		
		
		
	}

}
