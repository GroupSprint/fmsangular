import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Booking } from '../booking';
import { BookingService } from '../booking.service';
import { Passenger } from '../Passenger';

@Component({
  selector: 'app-createbooking',
  templateUrl: './createbooking.component.html',
  styleUrls: ['./createbooking.component.css']
})
export class CreatebookingComponent implements OnInit {
  booking:Booking=new Booking();
  addForm!:FormGroup;

  powers= [1,2]
  no1!:string;
  @Input()
  sessionUserId:string="";

  constructor(private service:BookingService,private formBuilder:FormBuilder,private router: Router) {
   }
  

  ngOnInit(): void {
    
    this.addForm=this.formBuilder.group({
      userId:[{value: '', disabled: true}],
      bookingDate:[{value: '', disabled: true}],
      ticketCost:[{value: '', disabled: true}],
      flight:[''],
      noOfPassangers:[1],
      // passengerList:[''],
      passengerName:[''],
      age:[''],
      passengerUIN:[''],
      luggage:[''],
      passengerName2:[''],
      age2:[''],
      passengerUIN2:[''],
      luggage2:[''],
     
    });
    
      this.no1=sessionStorage.getItem('userId') as string;
      this.addForm.value.userId=this.no1;
      var booking: string = sessionStorage.getItem("booking") as string;
      this.booking = JSON.parse(booking);
      // let date: Date = new Date();
      // this.addForm.value.bookingDate = date;
      // this.booking.bookingDate = this.addForm.value.bookingDate;
      // this.addForm.value.bookingDate = this.booking.bookingDate;
      this.addForm.value.ticketCost = this.booking.ticketCost;
    
  }
  createbooking(){
    var booking: string = sessionStorage.getItem("booking") as string;
    this.booking = JSON.parse(booking);
    let date: Date = new Date();
    this.addForm.value.bookingDate = date;
    this.booking.bookingDate = this.addForm.value.bookingDate;
    console.log("Show "+this.booking.bookingDate)
     var psgr:Passenger=new Passenger();
     psgr.passengerName=this.addForm.value.passengerName;
     psgr.passengerUIN=this.addForm.value.passengerUIN;
     psgr.luggage= this.addForm.value.luggage;
     psgr.age=this.addForm.value.age;
     var x1:number= this.booking.ticketCost;
     this.booking.passengerList[0]=psgr;
     this.booking.ticketCost = +x1;
     this.booking.noOfPassangers = this.addForm.value.noOfPassangers;

     if(this.addForm.value.noOfPassangers==2){
     var psgr2:Passenger=new Passenger();
     psgr2.passengerName=this.addForm.value.passengerName2;
     psgr2.passengerUIN=this.addForm.value.passengerUIN2;
     psgr2.luggage= this.addForm.value.luggage2;
     psgr2.age=this.addForm.value.age2; 
     this.booking.passengerList[1]=psgr2;
     this.booking.ticketCost += x1;
     
     }  
     console.log(this.booking);
   
    this.service.createbooking(this.booking)
     .subscribe(
       data => {console.log("Booking with ID"+data) 
         console.log(data.bookingId); alert('Thank You for Booking the tickets'); 
       sessionStorage.setItem("booking",JSON.stringify(data)); 
       sessionStorage.setItem("bookingid",data.bookingId+'');
       this.router.navigate(['/bookingdetails'])
      },
       error => { console.log(error);  alert(error);}
     );
     
 }
 onchange():void{
 }
}

