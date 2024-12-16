import { useState, useEffect } from 'react';
import { Book, BookOwnership } from '../types';
import { api } from '../api';

export function useBooks() {
  const [books, setBooks] = useState<Book[]>([]);
  const [ownerships, setOwnerships] = useState<Record<number, BookOwnership[]>>({});
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  const loadBooks = async () => {
    try {
      setError(null);
      const booksData = await api.getAllBooks();
      setBooks(booksData);
      
      const ownershipData: Record<number, BookOwnership[]> = {};
      for (const book of booksData) {
        const ownership = await api.getBookOwnership(book.id);
        ownershipData[book.id] = ownership;
      }
      setOwnerships(ownershipData);
    } catch (error) {
      setError('Failed to load books');
      console.error('Error loading books:', error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    loadBooks();
  }, []);

  return { books, ownerships, loading, error, refreshBooks: loadBooks };
}