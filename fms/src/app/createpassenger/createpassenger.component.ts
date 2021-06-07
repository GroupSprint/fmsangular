import { Component, OnInit } from '@angular/core';
import { Passenger } from '../Passenger';
import { PassengerService } from '../passenger.service';
import { UserhomeComponent } from '../userhome/userhome.component';

@Component({
  selector: 'app-createpassenger',
  templateUrl: './createpassenger.component.html',
  styleUrls: ['./createpassenger.component.css']
})
export class CreatepassengerComponent implements OnInit {
  passenger:Passenger=new Passenger();
  constructor(private service:PassengerService) { }

  ngOnInit(): void {
  }
  savepassenger(){
     this.service.createPassenger(this.passenger)
      .subscribe(
        data => { console.log(data); alert('Passenger added with PNR No:'+this.passenger.pnrNumber);},
        error => { console.log(error);  alert(error);}
      );
  }

}
