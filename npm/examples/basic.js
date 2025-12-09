/**
 * Basic Example - Permutation & Combination Calculator API
 *
 * This example demonstrates how to use the Permutation & Combination Calculator API.
 * Make sure to set your API key in the .env file or replace '[YOUR_API_KEY]' below.
 */

require('dotenv').config();
const permutationcombinationAPI = require('../index.js');

// Initialize the API client
const api = new permutationcombinationAPI({
    api_key: process.env.API_KEY || '[YOUR_API_KEY]'
});

// Example query
var query = {
  n: 10,
  r: 3
};

// Make the API request using callback
console.log('Making request to Permutation & Combination Calculator API...\n');

api.execute(query, function (error, data) {
    if (error) {
        console.error('Error occurred:');
        if (error.error) {
            console.error('Message:', error.error);
            console.error('Status:', error.status);
        } else {
            console.error(JSON.stringify(error, null, 2));
        }
        return;
    }

    console.log('Response:');
    console.log(JSON.stringify(data, null, 2));
});
