import { Component, OnDestroy, OnInit } from "@angular/core";
import { Subscription } from "rxjs";
import { SongService } from "../services/song.service";
import { ISong } from "../types/song";

@Component({
    selector: 'random-song',
    templateUrl: 'random-song.component.html',
    styleUrls: ['./random-song.component.css','../app.component.css', '../pure-min.css']
})
export class RandomSongComponent implements OnInit, OnDestroy{

    pageTitle: string = 'Random Song';
    randomSong!: ISong 
    errorMessage = '';
    sub!: Subscription;


    constructor(private songService: SongService) {}


    ngOnInit(): void {
        this.sub= this.songService.getRandomSong().subscribe({
            next: song => this.randomSong = song,
            error: err => this.errorMessage = err }
        );
    }

    ngOnDestroy(): void{
        this.sub.unsubscribe();
    }
}