import { Flight } from "./Flight"; 
import { Schedule } from "./Schedule";
export class ScheduledFlight{
     source!:string;
     destination!:string;
     schdate!:Date;
     flight:Flight=new Flight();
     schedule:Schedule=new Schedule();
     fares!:number;
     availableSeats!: number;
     scheduleFlightId!: number;
} 