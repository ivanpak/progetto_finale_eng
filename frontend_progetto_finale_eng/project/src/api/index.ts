const API_BASE_URL = 'http://localhost:8080/api/v1';

export const api = {
  // Auth
  login: async (credentials: LoginRequest) => {
    const response = await fetch(`${API_BASE_URL}/auth/login`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(credentials),
    });
    return response.text();
  },
  
  logout: async () => {
    const response = await fetch(`${API_BASE_URL}/auth/logout`);
    return response.text();
  },

  // Books
  getAllBooks: async () => {
    const response = await fetch(`${API_BASE_URL}/libri`);
    return response.json();
  },

  getBook: async (id: number) => {
    const response = await fetch(`${API_BASE_URL}/libri/id?id=${id}`);
    return response.json();
  },

  // Users
  getAllUsers: async () => {
    const response = await fetch(`${API_BASE_URL}/utenti`);
    return response.json();
  },

  // Book Ownership
  getBookOwnership: async (bookId: number) => {
    const response = await fetch(`${API_BASE_URL}/ownership/${bookId}`);
    return response.json();
  },

  borrowBook: async (bookId: number) => {
    const response = await fetch(`${API_BASE_URL}/ownership/toUtente/${bookId}`, {
      method: 'POST',
    });
    return response.json();
  },

  returnBook: async (bookId: number): Promise<void> => {
    try {
      const response = await fetch(`${API_BASE_URL}/ownership/${bookId}`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
      });
  
      // Controlla se la risposta è ok (status 200-299)
      if (response.ok) {
        const result = await response.json();
        alert(result.message || "Libro restituito con successo!");
      } else {
        // Gestisci errori specifici in base al codice di stato
        const errorResult = await response.json();
        alert(errorResult.message || "Si è verificato un errore.");
      }
    } catch (error) {
      // Gestisci errori di rete o altri errori imprevisti
      console.error("Errore durante la restituzione del libro:", error);
      alert("Errore di rete. Riprova più tardi.");
    }
  }
  
};