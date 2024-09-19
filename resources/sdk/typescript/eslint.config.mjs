// @ts-check

import js from '@eslint/js';  // ESLint core rules
import typescript from '@typescript-eslint/eslint-plugin';  // TypeScript ESLint plugin
import tsParser from '@typescript-eslint/parser';  // TypeScript parser

/**
 * @type {import("eslint").Linter.Config}
 */
export default {
  parser: tsParser,
  extends: [
    'eslint:recommended',
    'plugin:@typescript-eslint/recommended',
    'prettier'
  ],
  parserOptions: {
    ecmaVersion: 2020,
    sourceType: 'module',
    project: './tsconfig.json'  // Ensure tsconfig.json is at this path
  },
  plugins: ['@typescript-eslint'],
  rules: {
    // Add any custom rules here
  }
};
