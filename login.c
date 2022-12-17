#include<stdio.h>
void main()
{
    int id,pas;
    printf("enter id:");
    scanf("%d",&id);
    
    switch (id)
    {
        case 30:
        printf("enter passwoard:");
        scanf("%d",&pas);
        switch (pas)
        {
            case 99:
             printf("yo");
             break;
    
             default:
             printf("password is wrong");
             break;
        }
        break;
        default :
        printf("invalid");
        break;
    }


}

