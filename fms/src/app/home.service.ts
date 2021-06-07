import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class HomeService {
  private baseUrl =  'http://localhost:8082/fms/controller/scheduledFlightController';

  constructor(private http:HttpClient) { }

  getScheduleFlightByAirort(source: string,destination:string,date:Date): Observable<any> {
    return this.http.get(`${this.baseUrl}/viewAllScheduledFlightByAirport/${source}/${destination}/${date}`).pipe(catchError(this.handleError));
  }
  getScheduleflightById(schfid:number): Observable<any> {
    return this.http.get(`${this.baseUrl}/viewScheduledFlightById/${schfid}`).pipe(catchError(this.handleError));
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
