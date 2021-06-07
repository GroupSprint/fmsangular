import { Component, OnInit } from '@angular/core';
import { Booking } from '../booking';
import { BookingService } from '../booking.service';
import { ScheduledFlight } from '../ScheduledFlight';
import { ScheduleflightService } from '../scheduleflight.service';
import { User } from '../User';

@Component({
  selector: 'app-bookdetails',
  templateUrl: './bookdetails.component.html',
  styleUrls: ['./bookdetails.component.css']
})
export class BookdetailsComponent implements OnInit {
  bookingdetails: Booking=new Booking();
  schflight: ScheduledFlight = new ScheduledFlight();
  user:User =new User();

  constructor(private service:ScheduleflightService , private service1 : BookingService) { }

  ngOnInit(): void {
    var booking: string = sessionStorage.getItem("bookingid") as string;
    console.log("booking id ="+booking)
    this.bookingdetails.bookingId = +booking;
    this.service1.getbookinbyid(this.bookingdetails.bookingId).subscribe(
      data => {console.log(data); this.bookingdetails=data ;
        var sid:string = sessionStorage.getItem("schfids") as string;
        this.schflight.scheduleFlightId = +sid;
        this.service.viewflightbyid(this.schflight.scheduleFlightId).subscribe(
          data => {console.log(data); this.schflight=data },
          error =>{console.log(error)}
        );
      },
      error =>{console.log(error)}
    );
    console.log("Booking" +this.bookingdetails.bookingId);
    
    // this.schflight.schedule.sourceAirport.airportLocation = sessionStorage.getItem("ssairport") as string; 
    // this.schflight.schedule.destinationAirport.airportLocation = sessionStorage.getItem("deairport") as string; 
    // this.schflight.flight.carrierName = sessionStorage.getItem("carr") as string ;
    // this.schflight.flight.flightModel = sessionStorage.getItem("model") as string ;
    // this.schflight.schedule.departureTime =  sessionStorage.getItem("dtime") as string;
    // this.schflight.schedule.airrivalTime =  sessionStorage.getItem("atime") as string;
    // sessionStorage.setItem("schflights",JSON.stringify(this.schflight) );

  }

}
