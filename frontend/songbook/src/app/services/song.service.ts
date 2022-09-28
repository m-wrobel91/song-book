import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http'; 
import { catchError, Observable, tap, throwError } from 'rxjs';
import { ISong } from '../types/song';

//import { MessageService } from 

@Injectable({
  providedIn: 'root'
})
export class SongService {

  private songsUrl = 'http://localhost:8080/song/all';
  private randomSongUrl: string = 'http://localhost:8080/song/random';

  constructor(    private http: HttpClient) { }

  getSongs(): Observable<ISong[]> {
    return this.http.get<ISong[]>(this.songsUrl).pipe(
      tap(data => console.log('All: ', JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  getRandomSong(): Observable<ISong>{
    return this.http.get<ISong>(this.randomSongUrl).pipe(
      tap(data => console.log('All: ', JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  private handleError(err: HttpErrorResponse): Observable<never> {
    // in a real world app, we may send the server to some remote logging infrastructure
    // instead of just logging it to the console
    let errorMessage = '';
    if (err.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      errorMessage = `An error occurred: ${err.error.message}`;
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      errorMessage = `Server returned code: ${err.status}, error message is: ${err.message}`;
    }
    console.error(errorMessage);
    return throwError(() => errorMessage);
  }

}

//   /** Log a HeroService message with the MessageService */
// private log(message: string) {
//   this.messageService.add(`HeroService: ${message}`);
// }

