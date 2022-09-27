import { Component } from "@angular/core";
import { ISong } from "../types/song";

@Component({
    selector: 'song-search',
    templateUrl: 'song-search.component.html',
    styleUrls: ['../app.component.css']
})

export class SongSearchComponent {
    pageTitle: string = 'Song Search'
}
