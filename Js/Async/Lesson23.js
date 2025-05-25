// async/ await de thao tac voi peomise de dang hon chu khong thay the promise
// async khai bao mot ham la ham bat dong bo, async function thi tra ve promise

// let testPromise = new Promise((resolve, reject) => {
//   let callApiSuccess = true;
//   setTimeout(() => {
//     if (callApiSuccess) {
//       resolve("Sau 2s: goi thanh cong");
//     } else {
//       reject("Sau 2s: goi api that bai");
//     }
//   }, 2000);
// });

// const handleAsyncFuntion = async () => {
//   try {
//     const result = await testPromise; // await cho ket qua
//     console.log(result);
//   } catch (err) {
//     console.log(err);
//   }
// };

// handleAsyncFuntion()

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

  //IIFE
  // promise.all de chay song song cac tac vu khong lien quan den nhau
