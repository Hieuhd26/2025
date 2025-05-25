// const greet = (name, callback)=>{
//     console.log(` hello ${name}`);
//     callback()
// }

// greet("Hieu", ()=>{
//     console.log("nice to meet you");
// })

// let data = null;

// console.log("S1: Start read file, (roughly 3s)");
// console.log("S2: Simulating file reading");

// const readFile = (callback) => {
//   // vd doc file la mot tyac vu bat dong bo
//   setTimeout(() => {
//     console.log("S3: Reading file has done");
//     let data = "123";
//     callback(data);
//   }, 3000);
// };

// readFile((data) => {
//   console.log("S4: Reading has done, data is " + data);
// });

const getPokemon = (api, callback) => {
  const requestApi = new XMLHttpRequest();
  requestApi.open("GET", api);
  requestApi.onload = () => {
    if (requestApi.status >= 200 && requestApi.status <= 299) {
      const data = JSON.parse(requestApi.responseText);
      callback(data);
    }
  };
  requestApi.send();
};

getPokemon("https://pokeapi.co/api/v2/pokemon", (data) => {
  console.log(data);
});

// callback hell
/*
getListPokemon()
    pokemondetail()
        diadiemxuathien()
            abc()
*/
