import { ICategory } from "./category";

export interface ISong {
    id: number;
    title: string;
    lyrics: string;
    category: ICategory;
    duration: number;
  }