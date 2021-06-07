import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../booking';
import { BookingService } from '../booking.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {
  bookings!: Booking[];

  constructor(private service:BookingService) { }

  ngOnInit(): void {
    this.reloadData();    
  }
  reloadData() {
     this.service.getBookings().subscribe(
      data => { console.log(data); this.bookings=data },
      error => { console.log(error);}
     );
  }

}
