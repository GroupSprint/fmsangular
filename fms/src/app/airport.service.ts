import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Airport } from './Airport';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AirportService {

  private baseUrl = 'http://localhost:8082/fms/contoller/AirportController';

  constructor(private http: HttpClient) { }

  getAirports(): Observable<any>{
    return this.http.get(`${this.baseUrl}/getAllAirports`).pipe(catchError(this.handleError));
  }
  createairport(airport: Airport): Observable<any> {
    return this.http.post(`${this.baseUrl}` + `/addAirport`, airport).pipe(catchError(this.handleError));
  }
  geAirportById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/getAirportById/${id}`).pipe(catchError(this.handleError));
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