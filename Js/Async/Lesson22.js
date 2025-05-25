// promise la doi tuong trong js dai dien cho mot tac vu bat dong bo cn thoi gian de hoan thanh

// let testPromise = new Promise((resolve, reject)=>{
//     let callApiSuccess = false;
//     setTimeout(()=>{
//         if(callApiSuccess){
//             resolve("Sau 2s: goi thanh cong")
//         } else{
//             reject("Sau 2s: goi api that bai")
//         }
//     },2000)
// })

// console.log(testPromise);

// testPromise
//     .then((result)=>{
//             console.log(result);
//     })
//     .catch(err =>{
//         console.log(err);
//     })
//     .finally(()=>{
//         console.log("Hoan that xu li Promise");
//     })

let data = null;

console.log("S1: Start read file, (roughly 3s)");
console.log("S2: Simulating file reading");

const readFile = () => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      console.log("S3: Reading file has done");
      data = "123";
      resolve(data);
      //   reject("Loi bat ngo")
    }, 3000);
  });
};

readFile()
  .then((result) => {
    console.log(result);
  })
  .catch((err) => {
    console.log(err);
  });

  //promise chaining or Promise hell
