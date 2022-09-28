import { Component, OnDestroy, OnInit } from "@angular/core";
import { Subscription } from "rxjs";
import { ISong } from "../types/song";
import { SongService } from "../services/song.service";



@Component({
    selector: 'song-list',
    templateUrl: 'song-list.component.html',
    styleUrls: ['./song-list.component.css','../app.component.css', '../pure-min.css']
})
export class SongListComponent implements OnInit, OnDestroy{

    pageTitle: string = 'SongList';
    songList!: ISong[];
    errorMessage = '';
    sub!: Subscription;

    constructor(private songService: SongService) {}

    ngOnInit(): void {
        console.log("i am in init", this.songList);
        this.sub= this.songService.getSongs().subscribe({
            next: songs => this.songList = songs,
            error: err => this.errorMessage = err }
        );
    }

    ngOnDestroy(): void{
        this.sub.unsubscribe();
    }
}