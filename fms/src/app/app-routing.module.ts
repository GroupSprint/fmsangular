import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { AirportComponent } from './airport/airport.component';
import { BookingComponent } from './booking/booking.component';
import { CreateairportComponent } from './createairport/createairport.component';
import { CreatebookingComponent } from './createbooking/createbooking.component';
import { CreateflightComponent } from './createflight/createflight.component';
import { CreatepassengerComponent } from './createpassenger/createpassenger.component';
import { CreateschflightComponent } from './createschflight/createschflight.component';
import { CreateuserComponent } from './createuser/createuser.component';
import { FlightComponent } from './flight/flight.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { ScheduleflightComponent } from './scheduleflight/scheduleflight.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserComponent } from './user/user.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { ViewpassengerComponent } from './viewpassenger/viewpassenger.component';

const routes: Routes = [
  { path: 'Userdetails', component: UserComponent },
  { path: 'Scheduledetails', component: ScheduleComponent },
  { path: '', component: HomepageComponent },
  { path: 'airportdetails', component: AirportComponent },
  { path: 'flightdetails', component: FlightComponent },
  { path: 'Scheduleflightdetails', component: ScheduleflightComponent },
  { path: 'addflightdetails', component: CreateflightComponent },
  { path: 'addairportdetails', component: CreateairportComponent },
  { path: 'adduser', component: CreateuserComponent },
  { path: 'Login', component: LoginComponent },
  { path: 'passenger', component: ViewpassengerComponent },
  { path: 'adminhome', component: AdminhomeComponent },
  { path: 'booking', component: BookingComponent },
  { path: 'userhome', component: UserhomeComponent },
  { path: 'createpassenger',component: CreatepassengerComponent},
  { path: 'createbooking', component: CreatebookingComponent },
  { path: 'createscheduleflight', component: CreateschflightComponent},
  { path: 'logout', component: LogoutComponent},
  { path: 'bookingdetails', component:BookingComponent},
  { path: 'userprofile', component:UserProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
