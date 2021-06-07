import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../User';
import { UserService } from '../user.service';

@Component({
  selector: 'app-createuser',
  templateUrl: './createuser.component.html',
  styleUrls: ['./createuser.component.css']
})
export class CreateuserComponent implements OnInit {

  addForm!: FormGroup;
  Submitted = false;
  
  user:User=new User();
  constructor(private service : UserService,private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.addForm = this.formBuilder.group({
      userName :['', [Validators.required, Validators.minLength(2)]],
      password : ['',[Validators.required, Validators.minLength(6)]],
      email : ['',[Validators.required, Validators.email]],
      mobileNumber : ['',[Validators.required, Validators.minLength(10), Validators.maxLength(10)]]
    });
  }
  saveuser(){
    this.Submitted = true;
      if (this.addForm.invalid) {
        return;
      }

      else{
        this.user.userType='Customer';
        this.service.createUser(this.user)
      .subscribe(
        data => { console.log(data); this.user.userName = this.addForm.value.userName;
          this.user.password = this.addForm.value.password; this.user.email = this.addForm.value.email;
          this.user.mobileNumber = this.addForm.value.mobileNumber;
          alert('Registration Sucessful'); this.router.navigate(['/Login'])},
        error => { console.log(error);  alert(error);}
      );
      }
    
  }
}
