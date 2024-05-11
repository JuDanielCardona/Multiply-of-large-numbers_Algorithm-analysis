package org.multiply_methods.methods.divide;

import java.util.Arrays;

public class DivideVenceras {

    public int[] multiplicar(int Num[],int Num2[],int tam){

        int x[],y[],z[],w[],p[],q[],r[],wy[],xz[],s[], aux[],aux2[],i,a[],b[];


        if(tam>=64){

            x=new int[tam/2];
            y=new int[tam/2];
            z=new int[tam/2];
            w=new int[tam/2];

            for(i=0;i<tam/2;i++){
                w[i]=Num[i];
                y[i]=Num2[i];
                x[i]=Num[i+(tam/2)];
                z[i]=Num2[i+(tam/2)];
            }

            p=suma2(w,x,tam/2);

            if(p.length%2!=0){
                aux=new int[p.length+1];
                for(i=0;i<p.length;i++)aux[i+1]=p[i];
            }
            else{
                aux=new int[p.length];
                for(i=0;i<p.length;i++)aux[i]=p[i];
            }

            q=suma2(y,z,tam/2);

            if(q.length%2!=0){
                aux2=new int[q.length+1];
                for(i=0;i<q.length;i++)aux2[i+1]=q[i];
            }
            else{
                aux2=new int[q.length];
                for(i=0;i<q.length;i++)aux2[i]=q[i];
            }

            r=multiplicar(aux,aux2,p.length+1);
            wy=multiplicar(w,y,tam/2);
            xz=multiplicar(x,z,tam/2);

            r=resta(r,r.length,wy,wy.length);
            r=resta(r,r.length,xz,xz.length);

            a=new int[wy.length+tam];
            iniceros(a,wy.length+tam);

            for(i=0;i<wy.length;i++){
                a[i]=wy[i];
            }

            b=new int[r.length+(tam/2)];
            for(i=0;i<r.length;i++){
                b[i]=r[i];
            }

            s=suma(a,wy.length+tam,b,r.length+(tam/2));
            s=suma(s,s.length,xz,xz.length);
        }
        else
        {
            return multiplicarClasico(Num,Num.length,Num2,Num2.length);
        }

        return s;
    }

    public int[] suma2(int vec1[],int vec2[],int n){
        int resu[];
        int k,p,r,i,j;

        resu=new int [n+1];

        iniceros(resu,n+1);
        j=n;
        for(i=n-1;i>=0;i--){
            k=vec1[i]+vec2[i];
            if(k>9){
                p=k%10;
                r=k/10;
                resu[j]=resu[j]+p;
                resu[j-1]=r;
            }
            else{
                resu[j]=resu[j]+k;
            }
            j--;
        }


        return resu;
    }

    void iniceros(int arre[],int tam)
    {

        for(int i=0; i<tam; i++)
        {
            arre[i]=0;
        }
    }

    int[] resta(int Num[],int tam,int Num2[],int tam2){
        int r,j,carry=0,i;
        int resu[];


        resu=new int[tam];

        for(i=0;i<tam;i++){
            resu[i]=0;
        }

        for(i=tam-1,j=tam2-1;j>=0;i--,j--){
            if(Num[i]>=Num2[j]){
                if((Num[i]+carry)>=Num2[j]){
                    resu[i]=resu[i]+(Num[i]+carry)-Num2[j];
                    carry=0;
                }
                else{  	r=Num[i]+carry+10;
                    resu[i]=resu[i]+(r-Num2[j]);
                    carry=-1;

                }
            }
            else
            {
                r=Num[i]+10;
                resu[i]=resu[i]+(r-Num2[j]+carry);
                carry=-1;
            }
        }
        resu[i]+=carry;

        for(j=i;j>=0;j--){
            resu[j]+=Num[j];
        }


        return resu;
    }

    public int[] suma(int vec1[],int n,int vec2[],int m ){
        int resu[];
        int k,p,r,s,i,j,l,aux,aux2,tam;

        if(n>m||n==m)
        { aux=m;
            aux2=n;
        }
        else{ aux=n;
            aux2=m;
        }

        resu=new int[aux2];
        iniceros(resu,aux2);
        k=aux2-1;
        for(i=aux-1,l=aux2-1;i>=0;i--,l--)
        { p=vec1[l]+vec2[i];
            if(p>9)
            { r=p%10;
                s=p/10;
                resu[k]+=r;

                resu[k-1]+=s;
            }
            else{
                resu[k]+=p;
                if(resu[k]>9)
                {
                    r=resu[k]%10;
                    s=resu[k]/10;
                    resu[k]=r;
                    resu[k-1]+=s;
                }

            }
            k--;
        }
        if(n!=m)
            for(i=l;i>=0&&l>=0;i--,l--)
            {
                if(n>m) resu[i]+=vec1[l];
                else resu[i]+=vec2[l];
            }


        return resu;
    }

    public int[] multiplicarClasico(int numeroA[], int tam1, int numeroB[], int tam2) {
        int l = tam1 + tam2 - 1, pos = tam1 + tam2 - 1;
        int res[] = new int[tam1 + tam2];

        for (int y = 0; y <= tam1 + tam2 - 1; y++) {
            res[y] = 0;
        }

        for (int i = tam1 - 1; i >= 0; i--) {
            for (int j = tam2 - 1; j >= 0; j--) {
                res[l] += numeroA[i] * numeroB[j];
                if (res[l] > 9) {
                    res[l - 1] += res[l] / 10;
                    res[l] = res[l] % 10;
                }
                l--;
            }
            l = pos;
            pos--;
            l--;
        }
        return res;
    }

}
