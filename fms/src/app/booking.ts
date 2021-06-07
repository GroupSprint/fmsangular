import { Flight } from "./Flight";
import { Passenger } from "./Passenger";
import { User } from "./User";

export class Booking{
    bookingId!:number;
    userId:User=new User();
    bookingDate!:Date;
    ticketCost!:number;
    flight:Flight=new Flight();
    noOfPassangers!:number;
    // passengerList:Passenger=new Passenger();
    passengerList:Passenger[]=new Array();
}