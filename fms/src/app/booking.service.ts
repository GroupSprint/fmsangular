import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Booking } from './booking';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  private baseUrl =  'http://localhost:8082/fms/controller/bookingController';
  constructor(private http:HttpClient) { }

  getBookings(): Observable<any> {
    return this.http.get(`${this.baseUrl}/getAllBookings`).pipe(catchError(this.handleError));
}
createbooking(booking: Booking): Observable<any> {
  return this.http.post(`${this.baseUrl}` + `/addBooking`, booking).pipe(catchError(this.handleError));
}

getbookinbyid(id:number): Observable<any>{
  return this.http.get(`${this.baseUrl}`+`/viewBooking/${id}`).pipe(catchError(this.handleError));
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
