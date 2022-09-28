import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { RandomSongComponent } from './components/random-song.component';
import { SongListComponent } from './components/song-list.component';
import { SongSearchComponent } from './components/song-search.component';
import { CommonModule } from '@angular/common';  

@NgModule({
  declarations: [
    AppComponent,
    RandomSongComponent,
    SongListComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: 'randomSong', component: RandomSongComponent },
      { path: 'song-list', component: SongListComponent },
      { path: 'search-song/:phrase', component: SongSearchComponent },
      { path: '', redirectTo: 'randomSong', pathMatch: 'full' },
      { path: '**', redirectTo: 'randomSong', pathMatch: 'full' }
     ]),
    // ProductModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }