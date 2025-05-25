
let data =null

console.log("S1: Start read file, (roughly 3s)");
console.log("S2: Simulating file reading");

const readFile = ()=>{
    setTimeout(()=>{
        console.log("S3: Reading file has done");
        data = "123"
    },3000)
}

readFile()
console.log("S4: Reading has done, data is "+ data);
