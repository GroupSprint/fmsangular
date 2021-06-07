import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Schedule } from './Schedule';
import { catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class ScheduleService {

  private baseUrl =  'http://localhost:8082/fms/ScheduleController';

  constructor(private http:HttpClient) { }

  getAllSchedules(): Observable<any> {
    return this.http.get(`${this.baseUrl}/getAllSchedules`).pipe(catchError(this.handleError));
}
addschedule(schedule: Schedule): Observable<any> {
  return this.http.post(`${this.baseUrl}` + `/addSchedule`, schedule).pipe(catchError(this.handleError));
}
geScheduleById(id: number): Observable<any> {
  return this.http.get(`${this.baseUrl}/getScheduleById/${id}`).pipe(catchError(this.handleError));
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