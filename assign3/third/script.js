let url="https://reqres.in/api/register";
async function getData(url)
{
    let re=await fetch(url);
    res=await re.json();
    console.log(res);
    putData(res);
}

getData(url);

function putData(res)
{
    let table=`<thead><tr>
                <th>Id</th>
                <th>Name</th>
                <th>Year</th>
                <th>Color</th>
                <th>Pantone_value</th>
                </tr></thead><tbody>`;
    for(let elem of res.data)
    {
        table+=`<tr>
                <td>${elem.id}</td>
                <td>${elem.name}</td>
                <td>${elem.year}</td>
                <td>${elem.color}</td>
                <td>${elem.pantone_value}</td>
                </tr>
         `
    }
    table+=`</tbody>`;
    document.getElementById('data').innerHTML=table;
}