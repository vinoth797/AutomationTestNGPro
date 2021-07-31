package org.testng.test;

import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNgAdactinHotel extends BaseClass {

	@BeforeClass
	public static void beforeClass() {
	browserLanch();
	}

	@BeforeMethod
	public void before() {
	Date d=new Date();
	System.out.println("test starts " +d);
	}

	@Test
	public  void test1() {
		SoftAssert s = new SoftAssert();
		launchUrl("http://adactinhotelapp.com/index.php");
		s.assertTrue(driver.getCurrentUrl().contains("hotel"),"verify URL");
		login l = new login();
		sendkey(l.getUserName(), "devendrandeva");
		s.assertEquals("devendrandeva", l.getUserName().getAttribute("value"), "verify username");
		sendkey(l.getPassword(), "1234567890");
		s.assertEquals("123456789", l.getPassword().getAttribute("value"), "verify paassword");
		clickButton(l.getClick());
		s.assertAll();
		
	}

	
	@Test
	public void test2() {
		
		SearchHotel hotel = new SearchHotel();
	selectValue(hotel.getLocation(), "New York");
	selectValue(hotel.getHotels(), "Hotel Sunshine");
	selectValue(hotel.getType(), "Super Deluxe");
	selectValue(hotel.getRoomno(),"1");
	hotel.getCheckindate().sendKeys("20/03/2021");
	hotel.getCheckoutdate().sendKeys("21/03/2021");
	selectValue(hotel.getAdultno(), "2");
	selectValue(hotel.getChildno(), "0");
	hotel.getSearch().click();
	}

	
	@Test
	public void test3() {
		SelectHotel hotel = new SelectHotel();
		clickButton(hotel.getRadiobutton());
		clickButton(hotel.getContinueclick());
		
	}

	@Test
	public void test4() {
		 BookaHotel bookaHotel = new BookaHotel();
		 sendkey(bookaHotel.getFirstname(), "devendran");
		 sendkey(bookaHotel.getLastname(), "veeraraj");
		 sendkey(bookaHotel.getAddress(), "chennai");
		 sendkey(bookaHotel.getCardnum(), "1234567890123456");
		 selectValue(bookaHotel.getCardtype(), "VISA");
		 selectValue(bookaHotel.getCdmon(), "4");
		 selectValue(bookaHotel.getCdyr(), "2013");
		 sendkey(bookaHotel.getCvv(), "890");
		 clickButton(bookaHotel.getBooknow());
	}

	
	@Test
	public void test5() throws InterruptedException {
		BookingConfirmation bc = new BookingConfirmation();
		Thread.sleep(9000);
		scrollDown(bc.getOrderid());
		moveCursor(bc.getOrderid());
		doubleClick();
		screenshot("./src./ss/hotel.png");
		System.out.print("the booking orderID is ");
		getText(bc.orderid);

	}


	@AfterMethod
	public  void after() {
		Date d=new Date();
		System.out.println("test ends " +d);
	}


	@AfterClass
	public static void afterClass() {
		// quit();
	}



	}

	

