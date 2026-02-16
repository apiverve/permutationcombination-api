declare module '@apiverve/permutationcombination' {
  export interface permutationcombinationOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface permutationcombinationResponse {
    status: string;
    error: string | null;
    data: PermutationCombinationCalculatorData;
    code?: number;
  }


  interface PermutationCombinationCalculatorData {
      n:           number;
      r:           number;
      permutation: number;
      combination: number;
      formulas:    Formulas;
  }
  
  interface Formulas {
      permutation: string;
      combination: string;
  }

  export default class permutationcombinationWrapper {
    constructor(options: permutationcombinationOptions);

    execute(callback: (error: any, data: permutationcombinationResponse | null) => void): Promise<permutationcombinationResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: permutationcombinationResponse | null) => void): Promise<permutationcombinationResponse>;
    execute(query?: Record<string, any>): Promise<permutationcombinationResponse>;
  }
}
