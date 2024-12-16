import { BookOwnership } from '../types';

export const isBookAvailable = (ownerships: BookOwnership[] | undefined): boolean => {
  if (!ownerships || ownerships.length === 0) return true;
  return ownerships.every(o => o.data_di_fine !== null);
};

export const formatDate = (date: string): string => {
  return new Date(date).toLocaleDateString('en-US', {
    year: 'numeric',
    month: 'long',
    day: 'numeric'
  });
};