import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Flight } from './Flight';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FlightService {
  
  private baseUrl = 'http://localhost:8082/fms/controller/flightController' ;
  
  constructor(private http:HttpClient) { }

  getflights(): Observable<any> {
    return this.http.get(`${this.baseUrl}/viewAllFlights`).pipe(catchError(this.handleError));
}
createflight(flight: Flight): Observable<any> {
  return this.http.post(`${this.baseUrl}` + `/addFlight`, flight).pipe(catchError(this.handleError));
}
geflightById(id: number): Observable<any> {
  return this.http.get(`${this.baseUrl}/viewFlight/${id}`).pipe(catchError(this.handleError));
}
editflight(flight: Flight): Observable<any> {
  return this.http.put(`${this.baseUrl}/updateFlight`, flight).pipe(catchError(this.handleError));
}
removeflightById(id:number): Observable<any> {
  return this.http.delete(`${this.baseUrl}/removeFlight/`+id).pipe(catchError(this.handleError));
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