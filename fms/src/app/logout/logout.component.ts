import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../User';
import { UserService } from '../user.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {
user:User = new User();
  constructor(private service: UserService, private router: Router) { }

  ngOnInit(): void {
    var uid:string = sessionStorage.getItem("userId") as string;
    this.user.userId = +uid;
this.service.getuserById(this.user.userId).subscribe(
  data =>{this.user=data; alert("Thank You for using Airline Services Mr." +this.user.userName );
  sessionStorage.removeItem("userId");
  sessionStorage.removeItem("userType");
  sessionStorage.removeItem("userName");
  console.log(sessionStorage.getItem("userId"));
  console.log(sessionStorage.getItem("userType"));
  console.log(sessionStorage.getItem("userName"));
  this.router.navigate(['/']) }
)
  }
}
