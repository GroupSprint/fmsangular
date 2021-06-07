import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { ScheduledFlight } from './ScheduledFlight';
import { catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class ScheduleflightService {
  private baseUrl =  'http://localhost:8082/fms/controller/scheduledFlightController';

  constructor(private http:HttpClient) { }

  getScheduleFlight(): Observable<any> {
    return this.http.get(`${this.baseUrl}/viewAllScheduledFlight`).pipe(catchError(this.handleError));
}
addscheduleflight(scheduleflight: ScheduledFlight): Observable<any> {
  return this.http.post(`${this.baseUrl}` + `/addScheduledFlight`, scheduleflight).pipe(catchError(this.handleError));
}
viewflightbyid(schfid:number): Observable<any> {
return this.http.get(`${this.baseUrl}/viewScheduledFlightById/${schfid}`).pipe(catchError(this.handleError));
}
deleteScheduledFlightById(schfid:number): Observable<any> {
  return this.http.get(`${this.baseUrl}/deleteScheduledFlightById/${schfid}`).pipe(catchError(this.handleError));
  }
  updateScheduledFlight(scheduleflight: ScheduledFlight): Observable<any> {
    return this.http.post(`${this.baseUrl}` + `/updateScheduledFlight`, scheduleflight).pipe(catchError(this.handleError));
  }
  viewAllScheduleByDate(date: Date): Observable<any> {
    return this.http.get(`${this.baseUrl}/viewAllScheduleByDate/${date}`).pipe(catchError(this.handleError));
}

private handleError(error: HttpErrorResponse){
  if(error.error instanceof ErrorEvent){
      console.error('Client Side Error: ' , error.error.message);
      alert('client side error');
  }else{
    console.error('Server Side Error: ', error);
    alert('Server side error');
  }
  return throwError('There is problem with Service');
}
}
