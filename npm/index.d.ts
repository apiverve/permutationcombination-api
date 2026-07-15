declare module '@apiverve/permutationcombination' {
  export interface permutationcombinationOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface permutationcombinationResponse {
    status: string;
    error: string | null;
    data: PermutationCombinationCalculatorData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface PermutationCombinationCalculatorData {
      n:           number | null;
      r:           number | null;
      permutation: number | null;
      combination: number | null;
      formulas:    Formulas;
  }
  
  interface Formulas {
      permutation: null | string;
      combination: null | string;
  }

  export default class permutationcombinationWrapper {
    constructor(options: permutationcombinationOptions);

    execute(callback: (error: any, data: permutationcombinationResponse | null) => void): Promise<permutationcombinationResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: permutationcombinationResponse | null) => void): Promise<permutationcombinationResponse>;
    execute(query?: Record<string, any>): Promise<permutationcombinationResponse>;
  }
}
