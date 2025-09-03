{
Una librería requiere el procesamiento de la información de sus productos. De cada
producto se conoce el código del producto, código de rubro (del 1 al 6) y precio.

Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:

a. Lea los datos de los productos y los almacene ordenados por código de producto y
agrupados por rubro, en una estructura de datos adecuada. El ingreso de los productos finaliza
cuando se lee el precio -1.

b. Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro.

c. Genere un vector (de a lo sumo 20 elementos) con los productos del rubro 3. Considerar que
puede haber más o menos de 20 productos del rubro 3. Si la cantidad de productos del rubro 3
es mayor a 20, almacenar los primeros 30 que están en la lista e ignore el resto.

d. Ordene, por precio, los elementos del vector generado en c) utilizando alguno de los dos
métodos vistos en la teoría.

e. Muestre los precios del vector resultante del punto d).

f. Calcule el promedio de los precios del vector resultante del punto d).
}

program libros;

const
	rubros=6;
	fin=-1;
	dimF=30;
	
type
	rangoRubro= 1..rubros;
    rangoDimF= 1..dimF;
	
	producto= record
		codProdu: integer;
		codRubro: rangoRubro;
		precio: real;
	end;
	
	lista=^nodo;
	
	nodo= record
		elem: producto;
		sig: lista;
	end;
	
	vecRubro= array[rangoRubro] of lista;
	vecRubroTres=array[rangoDimF] of producto;
	
procedure leerProducto(var p:producto);
begin
	readln(p.codProdu); 
	if (p.codProdu <> fin) then begin
		readln(p.codRubro); readln(p.precio);
	end;
end;

procedure inicializarVec(var vR:vecRubro);
var i:integer;
begin
	for i:=1 to rubros do vR[i]:=nil;
end;

procedure insertarOrdenar(var l:lista; p:producto);
var act,ant,nue:lista;
begin
	new(nue);
	nue^.elem:= p;
	act:= l;
	ant:=l;
	
	while (act <> nil) and (act^.elem.codProdu > p.codProdu) do begin
		ant:= act;
		act:= act^.sig;
	end;
		
	if (act = ant ) then	{Si es el primero o nil}
			l:= nue
	else
		ant^.sig:= nue;
	nue^.sig:= act;
end;

procedure cargarLista(var v:vecRubro);
var 
	p:producto;
begin
	leerProducto(p);
	while (p.codProdu <> fin ) do begin
		insertarOrdenar(v[p.codRubro],p);
		leerProducto(p);
	end;
end;

procedure imprimirLista(v:vecRubro);
var 
    i:integer;
    l:lista;
begin
	for i:=1 to rubros do begin
        l:= v[i];
        writeln('Rubro: ',i);
		while(l <> nil) do begin
			writeln(l^.elem.codProdu);
			l:= l^.sig;
		end;
	end;
end;

procedure cargarVecRubroTres(aux:lista; var v:vecRubroTres; var dimL:integer);
begin
	dimL:=0;
	while (aux <> nil) and (dimL < dimF) do begin
		v[dimL]:= aux^.elem;
		aux:= aux^.sig;
		dimL:= dimL + 1;
	end;
end;

procedure ordenarPorPrecio(var v:vecRubroTres; dimL:integer);
var 
	i, j, pos:integer; 
	aux:producto;
begin
	for i:=1 to (dimL-1) do begin
		pos:=i;
		for j:=i+1 to dimL do begin
			if (v[j].precio < v[pos].precio) then pos:= j;
		end;
		aux:= v[pos];
		v[pos]:= v[i];
		v[i]:= aux;
	end;
end;

procedure imprimirVec(v:vecRubroTres; dimL:integer);
var
	i:integer;
begin
	for i:=0 to dimL do begin
		writeln('Codigo: ', v[i].codProdu);
		writeln('Rubro: ', v[i].codRubro);
		writeln('Precio: ', v[i].precio:0:2);
	end;
end;

procedure calcularPromedio(var v:vecRubroTres; dimL:integer);
var
	suma:real;
	i:integer;
begin
	suma:=0;
	for i:=0 to dimL-1 do begin
		suma:= suma + v[i].precio;
	end;
	if (dimL > 0) then
		writeln('Promedio: ', (suma/dimL):0:2)
	else
		writeln('No hay elementos en el vector');
end;

var
	vR:vecRubro;
	vP:vecRubroTres;
	dimL:integer;
begin
	inicializarVec(vR);
	cargarLista(vR);
	imprimirLista(vR);
	cargarVecRubroTres(vR[3], vP, dimL);
	ordenarPorPrecio(vP, dimL);
	imprimirVec(vP, dimL);
	calcularPromedio(vP, dimL);
end.