package com.pom;

import org.openqa.selenium.WebDriver;

import com.pomclass.AboutUS;
import com.pomclass.Careers;
import com.pomclass.CaseStudies;
import com.pomclass.Contact;
import com.pomclass.HomePage;
import com.pomclass.Industries;
import com.pomclass.MigrationAndModernization;
import com.pomclass.Partners;
import com.pomclass.PrivacyPolicy;
import com.pomclass.ProductEngineering;
import com.pomclass.ServicesPage;
import com.pomclass.SocialMedia;
import com.pomclass.StaffAugmentation;
import com.pomclass.WhitePaper;

public class PageObjectModel {

	private WebDriver driver;
	private ServicesPage services;
	private HomePage home;
	private MigrationAndModernization mm;
	private Careers car;
	private Contact contact;
	private AboutUS aboutus;
	private CaseStudies casestudies;
	private Industries industries;
	private Partners partners;
	private PrivacyPolicy privacypolicy;
	private ProductEngineering proeng;
	private SocialMedia socialmedia;
    private StaffAugmentation staff;
    private WhitePaper whitepaper;
	
	
	public PageObjectModel(WebDriver driver) {
		this.driver = driver;

	}

	public ServicesPage getInstanceServicePage() {
		if (services == null) {
			services = new ServicesPage(driver);
		}

		return services;

	}

	public HomePage getinstanceHomePage() {
		if (home == null) {
			home = new HomePage(driver);
		}
		return home;
	}

	public MigrationAndModernization getInstanceMigrationAndModernixation() {
		if (mm == null) {
			mm = new MigrationAndModernization(driver);
		}
		return mm;
	}

	public Careers getInstanceCareers() {
		if (car == null) {
			car = new Careers(driver);
		}
		return car;
	}

	public Contact getInstanceContact() {
		if (contact == null) {
			contact = new Contact(driver);
		}
		return contact;
	}

	public AboutUS getInstanceAboutUs() {

		if (aboutus == null) {
			aboutus = new AboutUS(driver);
			return aboutus;
		}
		return aboutus;
	}

	public CaseStudies getInstanceCaseStudies() {

		if (casestudies == null) {
			casestudies = new CaseStudies(driver);
			return casestudies;
		}
		return casestudies;
	}

	public Industries getInstanceIndustries() {

		if (industries == null) {
			industries = new Industries(driver);
			return industries;
		}
		return industries;
	}

	public Partners getInstancePartners() {

		if (partners == null) {
			partners = new Partners(driver);
			return partners;
		}
		return partners;
	}

	public PrivacyPolicy getInstancePrivacyPolicy() {

		if (privacypolicy == null) {
			privacypolicy = new PrivacyPolicy(driver);
			return privacypolicy;
		}
		return privacypolicy;
	}

	public ProductEngineering getInstanceProductEngineering() {

		if (proeng == null) {
			proeng = new ProductEngineering(driver);
			return proeng;
		}
		return proeng;
	}
	
	 public SocialMedia getInstanceSocialMedia() {

	        if (socialmedia == null) {
	        	socialmedia = new SocialMedia(driver);
	            return socialmedia;
	        }
	        return socialmedia;
	    }
	 
	 public StaffAugmentation getInstanceStaffAugmentation() {

	        if (staff == null) {
	        	staff = new StaffAugmentation(driver);
	            return staff;
	        }
	        return staff;
	    }
	 
	 public WhitePaper getInstanceWhitePaper() {

	        if (whitepaper == null) {
	        	whitepaper = new WhitePaper(driver);
	            return whitepaper;
	        }
	        return whitepaper;
	    }
}
