import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable ,throwError} from 'rxjs';
import { Passenger } from './Passenger';
import { catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class PassengerService {
  
  private baseUrl = 'http://localhost:8082//fms/controller/passengerController' ;
  constructor(private http:HttpClient) { }

  getPassengerList(): Observable<any> {
     return this.http.get(`${this.baseUrl}/getAllPassenger`).pipe(catchError(this.handleError));
  }

  getPassenger(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/getPassengerByid/${id}`).pipe(catchError(this.handleError));
  }

  createPassenger(passenger: Passenger): Observable<any> {
    return this.http.post(`${this.baseUrl}/addPassenger`, passenger).pipe(catchError(this.handleError));
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