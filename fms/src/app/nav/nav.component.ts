import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  isLoggedUser :boolean = false
  isLoggedAdmin :boolean = false
  constructor(private service : UserService) { }

  ngOnInit(): void {
    this.isLoggedAdmin = this.service.isLoggedAdmin();
    console.log('value:'+this.isLoggedAdmin)
    this.isLoggedUser = this.service.isLoggedUser();
    console.log('value:'+this.isLoggedUser)
  }
  


}
