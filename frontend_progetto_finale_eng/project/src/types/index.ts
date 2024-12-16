export interface User {
  id: number;
  name?: string;
  email: string;
  password?: string;
}

export interface Book {
  id: number;
  nome: string;
  autore: string;
  isbn?: string;
  available?: boolean;
}

export interface BookOwnership {
  id: number;
  idUtente: number;
  idLibro: number;
  data_di_inizio: string;
  data_di_fine: string | null;
}

export interface LoginRequest {
  email: string;
  password: string;
}