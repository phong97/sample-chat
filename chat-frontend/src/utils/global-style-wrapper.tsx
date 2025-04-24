import React from 'react';
import { GlobalStyle as StyledGlobalStyle } from '../styles/global-styles';

// Wrapper component for GlobalStyle to fix TypeScript compatibility with React 18
export const GlobalStyleWrapper: React.FC = () => {
  return (
    // @ts-ignore - Ignoring TypeScript error for styled-components GlobalStyle
    <StyledGlobalStyle />
  );
};