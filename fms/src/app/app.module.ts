import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from './user.service';
import { HomepageComponent } from './homepage/homepage.component';
import { AirportComponent } from './airport/airport.component';
import { FlightComponent } from './flight/flight.component';
import { ScheduleflightComponent } from './scheduleflight/scheduleflight.component';
import { CreateflightComponent } from './createflight/createflight.component';
import { CreateairportComponent } from './createairport/createairport.component';
import { CreateuserComponent } from './createuser/createuser.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { LoginComponent } from './login/login.component';
import { ViewpassengerComponent } from './viewpassenger/viewpassenger.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { BookingComponent } from './booking/booking.component';
import { NavComponent } from './nav/nav.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { CreatepassengerComponent } from './createpassenger/createpassenger.component';
import { CreatebookingComponent } from './createbooking/createbooking.component';
import { CreateschflightComponent } from './createschflight/createschflight.component';
import { LogoutComponent } from './logout/logout.component';
import { BookdetailsComponent } from './bookdetails/bookdetails.component';
import { UserProfileComponent } from './user-profile/user-profile.component';



@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    HomepageComponent,
    AirportComponent,
    FlightComponent,
    ScheduleflightComponent,
    CreateflightComponent,
    CreateairportComponent,
    CreateuserComponent,
    ScheduleComponent,
    LoginComponent,
    ViewpassengerComponent,
    AdminhomeComponent,
    BookingComponent,
    NavComponent,
    UserhomeComponent,
    CreatepassengerComponent,
    CreatebookingComponent,
    CreateschflightComponent,
    LogoutComponent,
    BookdetailsComponent,
    UserProfileComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
