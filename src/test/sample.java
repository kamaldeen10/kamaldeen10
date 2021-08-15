package test;


import java.net.SocketTimeoutException;

public class sample {

	
		
	
	
	public static void main(String[] args) throws InterruptedException, SocketTimeoutException {
	

		Methods waitcall = new Methods ();
		waitcall.WaitforReadystate();
		
		
		Methods Browsercall = new Methods ();
		Browsercall.LoadBrowserProcess();

		Methods Logincall = new Methods ();
	Logincall.LoginProcess();
	
	Methods Menucall = new Methods ();
	Menucall.MenuNavigateProcess();
	
		
		
		Methods CreateTabcall = new Methods ();
		CreateTabcall.CreateTabProcess();
		
		Methods Agentdetailscall = new Methods ();
		Agentdetailscall.booking_Agentdetails();
		
		Methods Headerdetailscall = new Methods ();
		Headerdetailscall.booking_Headerdetails();
		
		Methods booking_FlightRoutingdetails1call = new Methods ();
		 booking_FlightRoutingdetails1call.booking_FlightRoutingdetails1();
		 
			Methods booking_FlightRoutingdetails2call = new Methods ();
			 booking_FlightRoutingdetails2call.booking_FlightRoutingdetails2();
			 
			 Methods  booking_Shipmentdetailscall =  new Methods ();
			 booking_Shipmentdetailscall.booking_Shipmentdetails();
			 
			 Methods  Booking_Savecall  =  new Methods ();
			 Booking_Savecall.Booking_Save();
			 
 				
					  
		
	}
}

