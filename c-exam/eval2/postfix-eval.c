#include <stdio.h>
#include <string.h>

#define MAX_EXPR_SIZE 100
#define MAX_STACK_SIZE 100

typedef enum {lparen, rparen, plus, minus, times, divide, mod, eos, operand} precedence;

int eval_new(); 
precedence getToken(char *, int *);
void push(int);
int pop();

char expr[MAX_EXPR_SIZE]; /* input string */
int stack[MAX_STACK_SIZE];

int top = -1;

int main() {
  scanf("%[^\n]s", expr);
  printf("%d\n", eval_new());
  return 0;
}

int eval_new() 
{
  precedence token;
  char symbol;
  int op1, op2;

  int n = 0; 
  int top = -1;

  token = getToken(&symbol, &n);
  while (token != eos) {
    if (token == operand) {
      push(symbol - '0');
    } else {
      op2 = pop();
      op1 = pop();
      switch (token) {
        case plus:  push(op1 + op2);  break;
        case minus: push(op1 - op2);  break;
        case times: push(op1 * op2);  break;
        case divide: push(op1 / op2); break;
        case mod: push(op1 % op2); break;
        default: break;
      } 
    }
    token = getToken(&symbol, &n);
  }
  return pop(); // return result
}

precedence getToken (char *symbol, int * n)
{
  *symbol = expr[(*n)++];
  switch (*symbol) {
    case '(' : return lparen;
    case ')' : return rparen;
    case '+' : return plus;
    case '-' : return minus;
    case '/' : return divide;
    case '*' : return times;
    case '%' : return mod;
    case '\0' : return eos;
    default : return operand;
  }
}

void push(int value)
{
  stack[++top] = value;
}

int pop()
{
  return stack[top--];
}

